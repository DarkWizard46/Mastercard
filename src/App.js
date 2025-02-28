import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Authentication from './views/authentication/Index';

const materialTheme = createTheme({
  palette: {
    primary: {
      main: "#1C37BE",
    },
    secondary: {
      main: "#E5E5F0",
    },
    error: {
      main: "#D10D0D",
    },
  },
  typography: {
    fontFamily: ["Poppins", "sans-serif"].join(","),
  },
});

// Simple forbidden page
const Forbidden = () => (
  <div>
    <h1>403 Error</h1>
    <h1>Forbidden</h1>
    <h4>Your role does not have access to this feature</h4>
    <h4>Role kamu tidak punya akses untuk fitur ini</h4>
  </div>
);

function App() {
  return (
    <ThemeProvider theme={materialTheme}>
      <ToastContainer
        position="top-right"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
      />
      <Router>
        <Routes>
        <Route exact path="/" element={<Authentication />} />
        <Route path="/access-denied" element={<Forbidden />} />
        </Routes>
      </Router>
    </ThemeProvider>
  );
}

export default App;
