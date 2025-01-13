import { DataState } from "../enum/data-state.enum";

export interface CustomResponse {
    timeStamp : Date;
    statusCode : number;
    status : string;
    reason : string;
    message : string;
    developerMessage : string;
    data : { ser}
}