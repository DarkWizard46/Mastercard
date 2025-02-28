import React, { useState } from "react";
import {
  Container,
  Box,
  Paper,
  Typography,
  FormControl,
  Button,
} from "@mui/material";
import LockIcon from "@mui/icons-material/Lock"; // Ikon gembok
import { BootstrapInput } from "../../components/inputs/Index";

const Login = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Login Data:", formData);
  };

  return (
    <Container
      maxWidth="xs"
      sx={{
        minHeight: "100vh",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <Paper
        elevation={5}
        sx={{
          padding: 4,
          borderRadius: 2,
          backgroundColor: "#F7F7F9",
          width: 380,
        }}
      >
        {/* Logo & Lock Icon */}
        <Box
          sx={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            marginBottom: 3,
          }}
        >
          <Typography variant="h5" fontWeight="bold" color="white">
            <span style={{ color: "#00a4e4" }}>Mastercard</span>
          </Typography>
          <LockIcon sx={{ fontSize: 32, color: "#b0b0b0" }} />
        </Box>

        {/* Form Login */}
        <form onSubmit={handleSubmit}>
          <Box sx={{ display: "grid", gap: 2 }}>
            {/* Input Username */}
            <FormControl variant="standard">
              <Typography
                sx={{ color: "#262B43", fontSize: 12, fontWeight: "bold", opacity: "90%" }}
              >
                Username :
              </Typography>
              <BootstrapInput
                name="username"
                value={formData.username}
                onChange={handleChange}
                placeholder="Enter username"
                sx={{
                  color: "black",
                  padding: "10px",
                  borderRadius: "5px",
                }}
              />
            </FormControl>

            {/* Input Password */}
            <FormControl variant="standard">
              <Typography
                sx={{ color: "#262B43", fontSize: 12, fontWeight: "bold" , opacity: "90%"}}
              >
                Password :
              </Typography>
              <BootstrapInput
                type="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                placeholder="Enter password"
                sx={{
                  color: "black",
                  padding: "10px",
                  borderRadius: "5px",
                }}
              />
            </FormControl>

            {/* Tombol Login */}
            <Button
              type="submit"
              variant="contained"
              sx={{
                backgroundColor: "#00a4e4",
                color: "white",
                padding: "10px",
                fontWeight: "bold",
                borderRadius: "5px",
                "&:hover": { backgroundColor: "#008ac9" },
              }}
            >
              Login
            </Button>
          </Box>
        </form>

        {/* Footer */}
        <Typography
          sx={{ color: "#aaa", textAlign: "center", fontSize: 12, marginTop: 3 }}
        >
          © 2025 Mastercard | Version 1.0.0
        </Typography>
      </Paper>
    </Container>
  );
};

export default Login;
