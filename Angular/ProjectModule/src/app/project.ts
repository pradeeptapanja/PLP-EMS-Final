export class Project{
    constructor (
        public projectCode:number=null,
        public projectDescription:string = "",
        public startDate:any = "",
        public endDate:any = "",
        public businessUnit: string= "",
        public status: string= "" ) {}
    }
