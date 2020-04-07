import { Component } from '@angular/core';

import { User } from './model/user';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'crudAngular';
  users: User[] = [
    {id: 1, username: 'Mario', password: 'yo', name: 'sapo', email: 'yo@yo'},
    {id: 2, username: 'Tomás', password: 'yo', name: 'lindo', email: 'yo@yo'},
    {id: 3, username: 'Nancy', password: 'yo', name: 'linda', email: 'yo@yo'}

  ];

  selectedUser: User = new User();

  public addOrEdit() {
    if (this.selectedUser.id === 0) {
      this.selectedUser.id = this.users.length + 1;
      this.users.push(this.selectedUser);
    }
    this.selectedUser = new User();
  }

  public openForEdit(user: User) {
    this.selectedUser = user;
  }

  public borrar() {
    if (confirm('¿Seguro de eliminar?')) {
      this.users = this.users.filter(cadaelemento => cadaelemento !== this.selectedUser);
      this.selectedUser = new User();
    }
  }

}
