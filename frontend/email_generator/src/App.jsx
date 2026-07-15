import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Navbar from "./components/Navbar";

import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import History from "./pages/History";
import Footer from "./components/Footer";

function App() {
  const userId = localStorage.getItem("userId");

  return (
    <BrowserRouter>
      <Navbar />

      <Routes>
        <Route
          path="/"
          element={
            userId ? (
              <Home />
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/history"
          element={
            userId ? (
              <History />
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/login"
          element={
            userId ? (
              <Navigate to="/" />
            ) : (
              <Login />
            )
          }
        />

        <Route
          path="/register"
          element={
            userId ? (
              <Navigate to="/" />
            ) : (
              <Register />
            )
          }
        />

        <Route
          path="*"
          element={<Navigate to="/" />}
        />
      </Routes>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
