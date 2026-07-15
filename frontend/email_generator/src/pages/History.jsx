import { useEffect, useState } from "react";
import HistoryCard from "../components/HistoryCard";
import API from "../services/api";

function History() {
  const [history, setHistory] =
    useState([]);

  const [loading, setLoading] =
    useState(true);

  const userId =
    localStorage.getItem("userId");

  const fetchHistory =
    async () => {
      try {
        const response =
          await API.get(
            `/history/${userId}`
          );

        setHistory(response.data);
      } catch (error) {
        console.error(error);
      } finally {
        setLoading(false);
      }
    };

  useEffect(() => {
    fetchHistory();
  }, []);

  const deleteHistory =
    async (historyId) => {
      const confirmDelete =
        window.confirm(
          "Delete this history?"
        );

      if (!confirmDelete) return;

      try {
        await API.delete(
          `/history/${historyId}`
        );

        setHistory((prev) =>
          prev.filter(
            (item) =>
              item.id !== historyId
          )
        );
      } catch (error) {
        console.error(error);
        alert(
          "Failed to delete history"
        );
      }
    };

  return (
    <div className="container">
      <h1>Email History</h1>

      {loading ? (
        <div className="loader"></div>
      ) : history.length === 0 ? (
        <p>No History Found</p>
      ) : (
        history.map((item) => (
          <HistoryCard
            key={item.id}
            item={item}
            onDelete={deleteHistory}
          />
        ))
      )}
    </div>
  );
}

export default History;
