function HistoryCard({
  item,
  onDelete
}) {
  return (
    <div className="history-card">
      <h3>Prompt</h3>

      <p>{item.prompt}</p>

      <h3>Generated Email</h3>

      <pre>{item.generatedEmail}</pre>

      <p>
        <strong>Date:</strong>{" "}
        {new Date(
          item.generatedAt
        ).toLocaleString()}
      </p>

      <button
        onClick={() => onDelete(item.id)}
      >
        Delete
      </button>
    </div>
  );
}

export default HistoryCard;