import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '@/_models';

@Injectable({ providedIn: 'root' })
export class UserService {

    //private config.apiUrl = '192.168.0.229:8080';

    constructor(private http: HttpClient) { }

   getAll() {
        return this.http.get<User[]>(`${config.apiUrl}/auth/users`);
    }

    register(user: User) {
        return this.http.post(`${config.apiUrl}/auth/register`, user);
    }

    delete(id: number) {
        return this.http.delete(`${config.apiUrl}/users/${id}`);
    }
}