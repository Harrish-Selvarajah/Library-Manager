export class Dvd{

    public dvdid: number;
    public titled: string;
    public sector: string;
    public availang: string;
    public sub: string;
    public producer: string;
    public actors: string;
    constructor(dvdid: number,titled: string, sector: string, availang: string,sub: string,producer: string,
        actors: string) {
             this.dvdid=dvdid;
             this.titled=titled;
             this.sector=sector;
             this.availang=availang;
             this.sub=sub;
             this.producer=producer;
             this.actors=actors;        
             }
}