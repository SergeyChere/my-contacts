import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import User from "../model/User";

@Injectable({
  providedIn: 'root'
})
export class HttpContactsService {

  constructor(private httpClient: HttpClient) { }

  getAllContacts(): Observable<any> {
    return this.httpClient.get<User[]>('api/getAllContacts');
  }

  getContact(id: number): Observable<any> {
    return this.httpClient.get<User[]>('api/getContact'+'?'+id);
  }

  getAllContactsByName(name: string): Observable<any> {
    return this.httpClient.get<User[]>('api/getAllContactsByName'+'?'+name);
  }

  getContactByPhone(phone: string): Observable<any> {
    return this.httpClient.get<User[]>('api/getContactByPhone'+'?'+phone);
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
