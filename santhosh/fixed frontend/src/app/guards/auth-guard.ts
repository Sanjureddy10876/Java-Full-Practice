import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Storage } from '@ionic/storage';
import { LoginService } from '../services/login/login.service';
import { NavController } from '@ionic/angular';
@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    constructor(private storage: Storage, private ls: LoginService, private nav: NavController) { }

    async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this.ls.getUser()) {
            return true;
        } else {
            let authToken = await this.storage.get('access_token');
            let refreshToken = await this.storage.get('refresh_token');
            if (authToken && refreshToken) {
                let isAllowed = await this.ls.refreshToken(refreshToken)
                    .then(async res => {
                        let user: any = res;
                        user['access_token'] = res.access_token;
                        user['refresh_token'] = res.refresh_token;
                        console.log('Before Values -->', authToken, refreshToken);
                        await this.ls.setUser(user).then(res => res);
                        console.log('After Values -->', this.ls.getUser().access_token, this.ls.getUser().refresh_token);
                        let isAllowed = await this.ls.loadUserInfo()
                            .then(async res => {
                                if (!res) {
                                    this.ls.reset();
                                    this.nav.navigateRoot(['/login']);
                                    return false;
                                } else {
                                    console.log('--before setuser', this.ls.getUser().access_token);
                                    let user: any = res;
                                    let updatedAuthToken = await this.storage.get('access_token');
                                    let updatedRefreshToken = await this.storage.get('refresh_token');
                                    user['access_token'] = updatedAuthToken;
                                    user['refresh_token'] = updatedRefreshToken;
                                    await this.ls.setUser(user).then(res => res);
                                    if (state.url.includes('login')) {
                                        this.nav.navigateRoot(['/welcome']);
                                    }
                                    console.log('--after setuser', this.ls.getUser().access_token);
                                    return true;
                                }
                            })
                            .catch(err => {
                                console.log('error occured while fetching user info', err);
                                this.ls.reset();
                                this.nav.navigateRoot(['/login']);
                                return false;
                            })
                        return isAllowed;
                    })
                    .catch(err => {
                        this.ls.reset();
                        this.nav.navigateRoot(['/login']);
                        return false;
                    });
                console.log("-->After");
                return isAllowed;
            } else {
                if (state.url.includes('login')) {
                    this.ls.reset();
                    return true;
                } else {
                    this.ls.reset();
                    this.nav.navigateRoot(['/login']);
                    return false;
                }
            }
        }
    }
}
