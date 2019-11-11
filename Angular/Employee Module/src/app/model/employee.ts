
export class Employee{
    

    constructor(
        public empId : string = '',
        public name : String='',
        public pan : String='',
        public designation : String='',
        public domain : String='',
        public dateOfJoining : any='',
        public dateOfBirth : any='',
        public salary : number=0.0,
        public email : String='',
        public bankName : String='',
        public accountNo : String='',
        public balance : number=0.0,
        public password : String='', 
        public viewStatus : boolean=true


    ){}
}