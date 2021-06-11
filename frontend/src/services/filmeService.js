import http from "./config";

export default {
  retornarFilmes: () => {
    return http().get("/filmes");
  }
};
