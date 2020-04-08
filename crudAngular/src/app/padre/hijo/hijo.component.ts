import { User } from './../../model/user';
import { Component, OnInit, Input, Output, EventEmitter, OnChanges } from '@angular/core';

@Component({
  selector: 'app-hijo',
  templateUrl: './hijo.component.html',
  styleUrls: ['./hijo.component.css']
})
export class HijoComponent implements OnInit, OnChanges {

  users: User [];
  @Output() enviarPapa = new EventEmitter<User>();
  @Input() recibirDePapa: User;

  constructor() {}

  ngOnChanges() {
    console.log(this.recibirDePapa);
    if (this.recibirDePapa !== undefined) {
      this.users.push(this.recibirDePapa);
      console.log(this.users);
    }
  }

  ngOnInit(): void {
    this.users = [
      {id: 1, username: 'Mario', password: 'yo', name: 'sapo', email: 'yo@yo'},
      {id: 2, username: 'Tomás', password: 'yo', name: 'lindo', email: 'yo@yo'},
      {id: 3, username: 'Nancy', password: 'yo', name: 'linda', email: 'yo@yo'}
    ];
  }

  public openForEdit(user: User) {
    this.enviarPapa.emit(user);
  }
  public borrar(user: User) {
    if (confirm('¿Seguro de eliminar?')) {
      this.users = this.users.filter(cadaelemento => cadaelemento !== user);
    }
  }


}
