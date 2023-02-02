export class Contacto {
    id?: number;
    email: string;
    asunto: string;
    cuerpo: string;

    constructor(email: string, asunto: string, cuerpo: string){
        this.email = email;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        
    }  
}
