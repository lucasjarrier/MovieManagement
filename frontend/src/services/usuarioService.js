import http from "./config";

export default {
  salvarUsuario: (usuario) => {
    return http().post("/usuario", { ...usuario });
  },
  retornarUsuarios: () => {
    return http().get("/usuario");
  },
  atualizarUsuario: (usuario) => {
    return http().put("/usuario", {...usuario});
  },
  deletarUsuario: (id) => {
    return http().delete(`/usuario/${id}`);
  }
};
