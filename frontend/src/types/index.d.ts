export interface Authentication {
  id: string;
  password: string;
}
export interface NullUser {
  id: number;
  nickName: string;
  profile: string;
}
type User = NullUser | null;
type RefUser = User | Ref;
