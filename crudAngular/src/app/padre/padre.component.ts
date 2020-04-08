import { User } from './../model/user';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-padre',
  templateUrl: './padre.component.html',
  styleUrls: ['./padre.component.css']
})
export class PadreComponent implements OnInit {

  constructor() {}

  users: User[];
  selectedUser: User = new User();
  mensajeHijo: User;
  mensaje: Array<number>;

  ngOnInit(): void {
  }

    public addOrEdit() {
      this.mensajeHijo = this.selectedUser;
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

    recibirSaludo($event) {
      console.log($event);
      this.selectedUser = $event;
    }

}
