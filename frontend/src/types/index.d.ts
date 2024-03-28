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
  songId: number | string;
  songName: string | null;
  songImageUrl: string | null;
  views: number;
  likeCount: number;
}
export interface SongDetail {
  beat: number;
  likeCount: number;
  lyricsList: string[] | string;
  songFileUrl: string;
  songId: number;
  songImageUrl: string;
  songKeywordlist: string[] | string;
  songName: string;
  views: number;
}

type RefSongDetail = SongDetail | null;
type User = NullUser | null;
type RefUser = User | Ref;
type RefSong = Song | null;
