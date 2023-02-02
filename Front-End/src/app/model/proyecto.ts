export class Proyecto {
    id?: number;
    nombreP: string;
    descripcionP: string;
    urlP: string;
    img:string;

    constructor(nombreP: string, descripcionP: string, urlP: string, img: string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.img = img;
    }   
}
