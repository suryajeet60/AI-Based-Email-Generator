import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
  headers: {
    "Content-Type": "application/json",
  },
});

// AUTH APIs
export const registerUser = async (userData) => {
  const response = await API.post(
    "/auth/register",
    userData
  );

  return response.data;
};

export const loginUser = async (loginData) => {
  const response = await API.post(
    "/auth/login",
    loginData
  );

  return response.data;
};

// EMAIL APIs
export const generateEmail = async (
  userId,
  prompt
) => {
  const response = await API.post(
    `/email/generate/${userId}`,
    {
      prompt,
    }
  );

  return response.data;
};

// HISTORY APIs
export const getHistory = async (
  userId
) => {
  const response = await API.get(
    `/history/${userId}`
  );

  return response.data;
};

export const deleteHistory = async (
  historyId
) => {
  const response = await API.delete(
    `/history/${historyId}`
  );

  return response.data;
};

export default API;
