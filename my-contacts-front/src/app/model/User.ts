import Address from "./Address";

export default class User {
  private _fullName: string;
  private _email: string;
  private _phones: [];
  private _addresses: [Address];

  constructor(fullName: string, email: string, phones: [], addresses: [Address]) {
    this._fullName=fullName;
    this._email=email;
    this._phones=phones;
    this._addresses=addresses;
  }

  get fullName(): string {
    return this.fullName;
  }

  get email(): string {
    return this.email;
  }

  get phones(): [] {
    return this.phones;
  }

  get addresses(): [{}] {
    return this.addresses;
  }

  set fullName(value) {
    this.fullName=value;
  }

  set email(value) {
    this.email=value;
  }

  set phones(value) {
    this.phones=value;
  }

  set addresses(value) {
    this.addresses=value;
  }
}
