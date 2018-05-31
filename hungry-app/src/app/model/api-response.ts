export class ApiResponse {
  code: number;
  status: string;
  data: any;

  constructor(code: number, status: string, data: any) {
    this.code = code;
    this.status = status;
    this.data = data;
  }
}
