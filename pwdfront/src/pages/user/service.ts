import { IUser } from './model'

export interface IParams {
	keyword?: string
	pageNumber: number
	pageSize: number
}

// 获取用户列表
const getUserList = async (params: IParams): Promise<{ list: IUser[]; total: number }> => {
	const result = await $request.get('/users', params)
	return {
		list: result.records,
		total: result.total,
	}
}
// 获取用户详情
const getUserDetail = (id: number) => $request.get(`/users/${id}`)

// 编辑/新增用户
const updateUser = (id: number, detail: IUser) => $request.put(`/users/${id}`, { ...detail })

const addUser = (detail: IUser) => $request.post('/users', { ...detail })

// 删除用户
// const deleteUser = (id: number | number[]) => $request.post(`/users/${id}`, { id })
const deleteUser = (id: number) => $request.delete(`/users/${id}`)

export default {
	getUserList,
	getUserDetail,
	updateUser,
	deleteUser,
	addUser,
}
