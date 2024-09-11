const fs = require('fs');

function calculaFaturamento() {
    fs.readFile('faturamento.json', 'utf8', (err, data) => {
        if (err) {
            console.error('Erro ao ler o arquivo:', err);
            return;
        }
    
        let faturamento;
        try {
            faturamento = JSON.parse(data);
        } catch (parseError) {
            console.error('Erro ao parsear o JSON:', parseError);
            return;
        }

        const diasComFaturamento = faturamento.filter(dia => dia.faturamento !== null && dia.faturamento !== undefined);

        if (diasComFaturamento.length === 0) {
            console.log('Não há dados de faturamento.');
            return;
        }

        const valores = diasComFaturamento.map(dia => dia.faturamento);
        const menorFaturamento = Math.min(...valores);
        const maiorFaturamento = Math.max(...valores);

        const totalFaturamento = valores.reduce((acc, curr) => acc + curr, 0);
        const mediaFaturamento = totalFaturamento / valores.length;

        const diasAcimaDaMedia = diasComFaturamento.filter(dia => dia.faturamento > mediaFaturamento).length;

        console.log('Menor valor de faturamento: R$', menorFaturamento.toFixed(2));
        console.log('Maior valor de faturamento: R$', maiorFaturamento.toFixed(2));
        console.log('Número de dias com faturamento acima da média: ', diasAcimaDaMedia);
    });
}

calculaFaturamento();