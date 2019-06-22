import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import User from "../model/User";

@Injectable({
  providedIn: 'root'
})
export class HttpContactsService {

  name: string;
  phone: string;

  constructor(private httpClient: HttpClient) { }

  getAllContacts(): Observable<any> {
    return this.httpClient.get<User[]>('api/getAllContacts');
  }

  getContact(id: number): Observable<any> {
    return this.httpClient.get<User[]>('api/getContact'+'?'+id);
  }

  getAllContactsByName(name): Observable<any> {
    return this.httpClient.get<User[]>('api/getAllContactsByName?name='+name);
  }

  getContactByPhone(phone): Observable<any> {
    return this.httpClient.get<User[]>('api/getContactByPhone?phone='+phone);
  }

  // createNewContact(): Observable<any> {
  //   return this.httpClient.get<User[]>('api/createNewContact');
  // }
  //
  // updateContact(): Observable<any> {
  //   return this.httpClient.get<User[]>('api/updateContact');
  // }
  //
  // deleteContact(): Observable<any> {
  //   return this.httpClient.get<User[]>('api/deleteContact');
  // }
}
