import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-landing',
  templateUrl: './landing.page.html',
  styleUrls: ['./landing.page.scss'],
})
export class LandingPage implements OnInit {

  constructor() { }

  ngOnInit() {
    let MirageLanding = {
      addClass: function (element, className) {
        if (element.classList)
          element.classList.add(className);
        else
          element.className += ' ' + className;
      },

      removeClass: function (element, className) {
        if (element.classList)
          element.classList.remove(className);
        else
          element.className = element.className.replace(new RegExp('(^|\\b)' + className.split(' ').join('|') + '(\\b|$)', 'gi'), ' ');
      },

      hasClass: function (element, className) {
        if (element.classList)
          return element.classList.contains(className);
        else
          return new RegExp('(^| )' + className + '( |$)', 'gi').test(element.className);
      },

      hideMenu: function () {
        this.removeClass(document.getElementById('landing-menu'), 'landing-menu-active');
        this.removeClass(document.getElementById('landing-menu-button'), 'landing-menu-active');
        this.removeClass(document.getElementById('landing-mask'), 'landing-menu-active');
      },

      showMenu: function () {
        this.addClass(document.getElementById('landing-menu'), 'landing-menu-active');
        this.addClass(document.getElementById('landing-menu-button'), 'landing-menu-active');
        this.addClass(document.getElementById('landing-mask'), 'landing-menu-active');
      }
    };

    document.getElementById('landing-menu-button').addEventListener('click', function (e) {
      var menu = document.getElementById('landing-menu');

      if (MirageLanding.hasClass(menu, 'landing-menu-active')) {
        MirageLanding.hideMenu();
      } else {
        MirageLanding.showMenu();
      }

      e.preventDefault();
    });

    document.getElementById('landing-mask').addEventListener('click', function (e) {
      MirageLanding.hideMenu();

      e.preventDefault();
    });

    var menuLinks = document.querySelectorAll('#landing-menu a');
    for (let i = 0; i < menuLinks.length; i++) {
      menuLinks[i].addEventListener('click', function (e) {
        MirageLanding.hideMenu();
      });
    }
  }

}
