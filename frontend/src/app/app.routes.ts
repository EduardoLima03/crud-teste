import { Routes } from '@angular/router';
import { User } from './views/user/user';

export const routes: Routes = [
    {
        path:'',
        loadComponent: () => import('./app').then(m => m.App)
    },
    {
        path: 'users',
        //loadComponent: () => import('./views/user/user').then(m => m.User)
        component: User
    }
];
