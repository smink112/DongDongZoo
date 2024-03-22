export interface Authentication {
  id: string;
  password: string;
}
export interface NullUser {
  id: number;
  nickName: string;
  profile: string;
}
export interface Dongyo {
  id : number;
  title: string;
  content: string;
}
type User = NullUser | null;
type RefUser = User | Ref;
type RefDongyo = Dongyo | null;
