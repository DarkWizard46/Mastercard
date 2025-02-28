export const loginUser = (credentials) => {
    return (dispatch) => {
        if (credentials.email === "admin@example.com" && credentials.password === "password") {
            dispatch({ type: "LOGIN_SUCCESS", payload: { user: credentials.email } });
        } else {
            dispatch({ type: "LOGIN_FAILURE", payload: "Invalid email or password" });
        }
    };
};
