import axios from "axios"

export default class AuthService {

    apiUrl = `${process.env.NEXT_PUBLIC_API_URL}/auth/`

    login(loginRequest) {
        return axios.post(this.apiUrl + "login", loginRequest);
    }

    register(registerRequest) {
        return axios.post(this.apiUrl + "register", registerRequest);
    }
}