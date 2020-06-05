import { User } from './User.model';

export interface Movie {
    id?: number;
    name: string;
    producer: string;
    year: string;
    user: User;
}