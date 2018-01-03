
export class User {
    id:         number;
    username:   string;
    name:       string;
    password:   string;
    role:       string;

    constructor() {}

    get getName(): string {
        return this.name;
    }

    get getRole(): string {
        return this.role;
    }
}