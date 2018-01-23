// class NodePlayList{
//   NodeSong song;
//   NodePlayList next = null;
//
//   NodePlayList(NodeSong s){
//     song = s;
//   }
// }
//
// class TailPlayList{
//   NodeSong head = null;
//   NodeSong tail = null;
//
//   void enqueue(NodeSong song){
//     NodePlayList newNode = new NodePlayList(song);
//
//     if(head == null){
//       head = newNode;
//     }else{
//       tail.next = tail;
//       tail = newNode;
//     }
//   }
//
//   NodeSong dequeue(){
//     NodeSong tempNode = head;
//     if(head != null){
//       head = head.next;
//       if(head == null){
//         tail = head;
//       }
//     }else{
//       return null;
//     }
//     return tempNode;
//   }
// }
