"use client";

import { useState, useEffect } from "react";

interface ChatRoom {
  id: number;
  createdDate: Date;
  updateDate: Date;
  name: string;
}

export default function App() {
  const [chatRooms, setChatRooms] = useState<ChatRoom[]>([]);

  useEffect(() => {
    async function fetchChatRooms() {
      const response = await fetch("http://localhost:8080/api/v1/chat/room");
      const data = await response.json();
      setChatRooms(data);
    }

    fetchChatRooms();
  }, []);

  return <div>{JSON.stringify(chatRooms)}</div>;
}
