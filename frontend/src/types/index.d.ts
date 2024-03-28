export interface Authentication {
  id: string;
  password: string;
}
export interface NullUser {
  id: number;
  nickName: string;
  profile: string;
}
export interface Song {
  songId: number;
  songName: string | null;
  songImageUrl: string | null;
  views: number;
  likeCount: number;
}

type User = NullUser | null;
type RefUser = User | Ref;
type RefSong = Song | null;

// import jQuery from "jquery";

// export interface JQueryImpl extends jQuery {
//   turn(options?: any): JQuery;
//   turn(method: any, options?: any): JQuery;
// }
