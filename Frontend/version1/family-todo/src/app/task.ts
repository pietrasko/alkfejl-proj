import { User } from "./user";

export class Task{
    id:         number;
    user:       User;
    completed:  boolean;
    completion_confirmed: boolean;
    task_description: string;
    deadline:   Date;
}