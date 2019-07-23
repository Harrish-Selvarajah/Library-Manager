export class Book{

    public isbn: string;
    public title: string;
    public sector: string;
    public publidate: Date;
    public author: string;
    public publisher: string;
    public noofpages: number;
    constructor(isbn: string,title: string,sector: string,publidate: Date,author: string,publisher: string,
         noofpages: number) {
             this.isbn=isbn;
             this.title=title;
             this.sector=sector;
             this.publidate=publidate;
             this.author=author;
             this.publisher=publisher;
             this.noofpages=noofpages;        
             }
}