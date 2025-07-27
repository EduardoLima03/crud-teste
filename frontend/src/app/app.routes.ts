import { Routes } from '@angular/router';
import { User } from './views/user/user';

export const routes: Routes = [
    {
        path:'',
        loadComponent: () => import('./views/home/home').then(m => m.Home)
    },
    {
        path: 'users',
        loadComponent: () => import('./views/user/user').then(m => m.User)
    },
    {
        path: 'users/form',
        loadComponent: () => import('./views/user-form/user-form').then(m => m.UserForm)
    }
];
