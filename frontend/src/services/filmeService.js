import http from "./config";

export default {
    salvarFilme: (filme) => {
        return http().post("/filme", {...filme});
    },
    retornarFilmes: () => {
        return http().get("/filmes");
    },
    atualizarFilme: (filme) => {
        return http().put("/filme", {...filme});
    },
    deletarFilme: (id) => {
        return http().delete(`/filme/${id}`);
    }
};
