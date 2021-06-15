import http from "./config";

export default {
    salvarFilme: (filme) => {
        return http().post("/filmes", {...filme});
    },
    retornarFilmes: () => {
        return http().get("/filmes");
    },
    atualizarFilme: (filme) => {
        return http().put("/filmes", {...filme});
    },
    deletarFilme: (id) => {
        return http().delete(`/filmes/${id}`);
    }
};
