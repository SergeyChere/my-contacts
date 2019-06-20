 export default class Address {

   private _country: string;
   private _city: string;
   private _street: string;
   private _houseNumber: string;
   private _apartment: string;

   constructor(country: string, city: string, street: string, houseNumber: string, apartment: string){
     this._country=country;
     this._city=city;
     this._street=street;
     this._houseNumber=houseNumber;
     this._apartment=apartment;
   }

   get country(): [{}] {
     return this.country;
   }

   get city(): [{}] {
     return this.city;
   }

   get street(): [{}] {
     return this.street;
   }

   get houseNumber(): [{}] {
     return this.houseNumber;
   }

   get apartment(): [{}] {
     return this.apartment;
   }

   set country(value) {
     this.country=value;
   }

   set city(value) {
     this.city=value;
   }

   set street(value) {
     this.street=value;
   }

   set houseNumber(value) {
     this.houseNumber=value;
   }

   set apartment(value) {
     this.apartment=value;
   }
 }
