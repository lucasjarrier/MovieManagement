import http from "./config";

export default {
  salvarUsuario: (usuario) => {
    return http().post("/usuario", { ...usuario });
  },
};
