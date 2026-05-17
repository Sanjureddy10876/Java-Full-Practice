import { TestBed } from '@angular/core/testing';

import { HttpHeaderInterceptorService } from './http-header-interceptor.service';

describe('HttpHeaderInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpHeaderInterceptorService = TestBed.get(HttpHeaderInterceptorService);
    expect(service).toBeTruthy();
  });
});
