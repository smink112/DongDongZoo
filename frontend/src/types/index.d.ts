export interface Authentication {
  email: string;
  password: string;
}
export interface SignUp {
  username: string;
  email: string;
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
  songKeywordList: string[] | string;
  songKeywordKoreanList: string[] | string;
  songName: string;
  views: number;
}

export interface StoryImageRes {
  startTime: number;
  content: string;
  imageURL: string | null;
}
type RefSongDetail = SongDetail | null;
type User = NullUser | string | null;
type RefUser = User | Ref;
type RefSong = Song | null;
type RefStoryImageRes = StoryImageRes | null;
