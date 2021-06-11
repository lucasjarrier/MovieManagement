import http from "./config";

export default {
    salvarDiretor: (diretor) => {
        return http().post("/diretor", {...diretor});
    },
    retornarDiretores: () => {
        return http().get("/diretor");
    },
    atualizarDiretor: (diretor) => {
        return http().put("/diretor", {...diretor});
    },
    deletarDiretor: (id) => {
        return http().delete(`/diretor/${id}`);
    }
};