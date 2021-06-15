import http from "./config";

export default {
    salvarFilme: (filme) => {
        return http().post("/filme", {...filme});
    },
    retornarFilme: () => {
        return http().get("/filme");
    },
    atualizarFilme: (filme) => {
        return http().put("/filme", {...filme});
    },
    deletarFilme: (id) => {
        return http().delete(`/filme/${id}`);
    }
};
