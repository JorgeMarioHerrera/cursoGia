import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tutorialGia';
  public botonesGrandes: string[] = ['AC', 'DEL'];
  public botones: string[] = ['9', '8', '7', '6', '5', '4', '3', '2', '1', '0', '+', '-', '*', '/', '='];
  public res = '';

  public   agregarElemento(valor: string): void {
    if (valor === 'AC') {
      // tslint:disable-next-line:no-unused-expression
      this.res = '';
    } else if (valor === 'DEL') {
      this.res.substring(0, this.res.length - 1);
    } else if (valor === '=') {
      // tslint:disable-next-line:no-eval
      this.res = eval(this.res);
    } else {
      this.res += valor;
    }
  }
}
