import { User } from "./user";

export class Task{
    id:         number;
    user:       string;
    completed:  boolean;
    completion_confirmed: boolean;
    task_description: string;
    deadline:   Date;
}