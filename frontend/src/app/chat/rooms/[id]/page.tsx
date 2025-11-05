"use client";

import { useParams } from "next/navigation";
import { useEffect, useState } from "react";

interface ChatRoom {
  id: number;
  createdDate: Date;
  updateDate: Date;
  name: string;
}

export default function ChatRoom() {
  const [chatRoom, setChatRoom] = useState<ChatRoom | null>(null);
  const { id } = useParams();

  const fetchChatRoom = async (id: string) => {
    const response = await fetch(
      `http://localhost:8080/api/v1/chat/rooms/${id}`
    );
    const data = await response.json();
    setChatRoom(data);
  };

  useEffect(() => {
    fetchChatRoom(id as string);
  }, [id]);

  return (
    <div>
      <h1>ChatRoom {chatRoom?.id}</h1>
      <p>{chatRoom?.name}</p>
      <p>{chatRoom?.createdDate?.toDateString()}</p>
    </div>
  );
}
