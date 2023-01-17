// 需要采用CommonJS的写法
const proxy = require('http-proxy-middleware')

// eslint-disable-next-line no-undef
module.exports = function (app) {
	app.use(
		proxy(
			'/server', // 遇见/api-elm前缀的请求,就会触发该代理配置
			{
				target: 'http://localhost:8080', // 请求转发给谁（能返回数据的服务器地址）
				secure: false,
				changeOrigin: true, // 控制服务器收到的响应头中Host字段的值
				pathRewrite: { '^/server': '/server' }, // 重写请求路径，保证交给后台服务器是正常地请求地址（必须配置）
			}
		)
	)
}
