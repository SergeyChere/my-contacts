import {Component, Input, OnInit, OnChanges, SimpleChanges, Injectable} from '@angular/core';
import {HttpContactsService} from "../services/http-contacts.service";
import User from "../model/User";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  user: User [] = [];

  @Input() name: string;
  @Input() phone: string;

  constructor(private httpService: HttpContactsService) {
  }

  getUsers() {
    return this.httpService
      .getAllContacts()
      .subscribe(data => this.user = data);
  }

  getAllContactsByName(name) {
    console.log(name);
    return this.httpService
      .getAllContactsByName(name)
      .subscribe(data => this.user = data);
  }

  getContactByPhone(phone) {
    return this.httpService
      .getContactByPhone(phone)
      .subscribe(data => this.user = data);
  }

  ngOnInit() {
    this.getUsers();
  }
}
