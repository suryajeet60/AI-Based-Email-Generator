import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import API from "../services/api";

function Login() {
  const navigate = useNavigate();

  const [email, setEmail] =
    useState("");

  const [password, setPassword] =
    useState("");

  const [loading, setLoading] =
    useState(false);

  const handleLogin = async () => {
    try {
      setLoading(true);

      const response =
        await API.post(
          "/auth/login",
          {
            email,
            password,
          }
        );

      localStorage.setItem(
        "userId",
        response.data.id
      );

      localStorage.setItem(
        "fullName",
        response.data.fullName
      );

      localStorage.setItem(
        "email",
        response.data.email
      );

      navigate("/");
      window.location.reload();
    } catch (error) {
      console.error(error);

      alert(
        error.response?.data?.message ||
          "Login Failed"
      );
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <h1>Login</h1>

      <input
        type="email"
        placeholder="Enter Email"
        value={email}
        onChange={(e) =>
          setEmail(e.target.value)
        }
      />

      <input
        type="password"
        placeholder="Enter Password"
        value={password}
        onChange={(e) =>
          setPassword(e.target.value)
        }
      />

      <button onClick={handleLogin}>
        {loading
          ? "Logging In..."
          : "Login"}
      </button>

      <div className="auth-link">
        <Link to="/register">
          Create New Account
        </Link>
      </div>
    </div>
  );
}

export default Login;