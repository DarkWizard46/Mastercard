const initialState = {
    isAuthenticated: false,
    user: null,
    error: null,
};

const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case "LOGIN_SUCCESS":
            return { ...state, isAuthenticated: true, user: action.payload.user, error: null };
        case "LOGIN_FAILURE":
            return { ...state, isAuthenticated: false, user: null, error: action.payload };
        default:
            return state;
    }
};

export default authReducer;
